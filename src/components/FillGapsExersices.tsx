"use client";
import { useState, useEffect } from "react";
import { Modal, Button as AntButton } from "antd";
import Button from "./ButtonUI";
import { getExercisesTrueFalse } from "@/app/pages";
import PresentModule from "./PresentModule";
import { useSession } from "next-auth/react";
import { useProgress } from "@/context/ProgressUserProvider";
import Confetti from "react-confetti"; // Importar el confeti
import { useRouter } from "next/navigation"; // Para volver al dashboard

type Exercise = {
  id: number;
  text: string;
  answers: string;
  completed: boolean;
  exerciseType: string[];
};


function FillGapsExercises() {
  const { increaseProgress } = useProgress();
  const { data: session } = useSession();
  const [showContent, setShowContent] = useState<boolean>(false);
  const [exercises, setExercises] = useState<Exercise[]>([]);
  const [currentExerciseIndex, setCurrentExerciseIndex] = useState(0);
  const [incorrect, setIncorrect] = useState(false);
  const [showConfetti, setShowConfetti] = useState(false); // Estado para el confeti
  const router = useRouter(); // Hook para la navegación

  useEffect(() => {
    const fetchData = async () => {
      const data = await getExercisesTrueFalse();
      setExercises(data);
    };
    fetchData();

    if (session) {
      const timer = setTimeout(() => {
        setShowContent(true);
      }, 3000);

      return () => clearTimeout(timer);
    }
  }, [session]);

  const handleButtonClick = (userAnswer: string) => {
    const currentExercise = exercises[currentExerciseIndex];

    if (currentExercise.answers === userAnswer) {
      increaseProgress();
      const updatedExercises = exercises.map((exercise, index) =>
        index === currentExerciseIndex
          ? { ...exercise, completed: true }
          : exercise
      );
      setExercises(updatedExercises);

      if (currentExerciseIndex < exercises.length - 1) {
        setCurrentExerciseIndex(currentExerciseIndex + 1);
      } else {
        // Si se han completado todos los ejercicios, mostramos el confeti
        setShowConfetti(true);
      }
    } else {
      setIncorrect(true);
      setTimeout(() => {
        setIncorrect(false);
      }, 1000);
    }
  };

  const handleReturnToDashboard = () => {
    router.push("/dashboard"); // Redirigir al dashboard
  };

  if (!session) {
    return <p>Debes iniciar sesión para acceder a los ejercicios.</p>;
  }

  return (
    <>
    {!showContent ? (
      <PresentModule />
    ) : (
      <>
        {exercises.length > 0 && (
          <div className="flex flex-col justify-center items-center animate-slideUp">
            <h1 className="text-4xl relative 2xl:bottom-20 xl:bottom-10 font-bold">
              Lee con atención y acierta verdadero o falso
            </h1>
            <p
              className={`text-shadow ${
                incorrect
                  ? "text-red-500 relative 2xl:text-3xl xl:text-2xl"
                  : "text-[#FCDE70] relative 2xl:text-3xl xl:text-2xl "
              }`}
            >
              {exercises[currentExerciseIndex]?.text}
            </p>
            <div className="flex items-center justify-center gap-6 p-10 relative 2xl:top-32 xl:top-20 animate-slideUp">
              <Button onClick={() => handleButtonClick("true")}>
                Verdadero
              </Button>
              <Button onClick={() => handleButtonClick("false")}>
                Falso
              </Button>
            </div>
          </div>
        )}

        {/* Modal para mostrar el confeti al finalizar */}
        <Modal
          title="¡Felicidades!"
          visible={showConfetti}
          onOk={handleReturnToDashboard} // Cerrar modal y redirigir al dashboard
          onCancel={handleReturnToDashboard}
          footer={[
            <AntButton key="submit" type="primary" onClick={handleReturnToDashboard}>
              Volver al Dashboard
            </AntButton>,
          ]}
        >
          <div className="flex flex-col items-center">
            <Confetti width={window.innerWidth} height={window.innerHeight} />
            <h2 className="text-3xl font-bold mt-4">
              ¡Has completado todos los ejercicios!
            </h2>
          </div>
        </Modal>
      </>
    )}
  </>
  );
}

export default FillGapsExercises;

