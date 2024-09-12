"use client";
import { useSession } from "next-auth/react";
import React, { useState, useEffect } from "react";
import Button from "./ButtonUI";

function FillGapsExercises() {
  const { data: session } = useSession();
  const [showContent, setShowContent] = useState<boolean>(false);
  const [selectedWords, setSelectedWords] = useState<{ [key: string]: string }>(
    {
      word1: "",
      word2: "",
    }
  );

  // const exercises = [
  //   {
  //     text: "I am Michel! I liked play ___ and ___ running in the park.",
  //     gaps: { word1: "Play", word2: "Running" },
  //     options: ["Play", "Eat", "Running", "Jump"],
  //   },
  //   {
  //     text: "She enjoys ___ and ___ at the beach.",
  //     gaps: { word1: "Swimming", word2: "Playing volleyball" },
  //     options: ["Swimming", "Eating", "Jumping", "Playing volleyball"],
  //   },
  //   // Puedes agregar más ejercicios aquí
  // ];

  const [incorrect, setIncorrect] = useState(false);

  const correctAnswers = {
    word1: "Play",
    word2: "Running",
  };

  const handleButtonClick = (word: string, position: "word1" | "word2") => {
    if (word === correctAnswers[position]) {
      setSelectedWords((prev) => ({ ...prev, [position]: word }));
      setIncorrect(false); // Correcto, no hay error
    } else {
      setIncorrect(true); // Respuesta incorrecta
      setTimeout(() => {
        setIncorrect(false);
      }, 1000);
    }
  };

  useEffect(() => {
    if (session) {
      const timer = setTimeout(() => {
        setShowContent(true);
      }, 3000);

      return () => clearTimeout(timer);
    }
  }, [session]);

  return (
    <>
      {session ? (
        <>
          {!showContent ? (
            <div className="welcome-screen flex items-center justify-center h-screen">
              <div className="text-center">
                <h1 className="text-6xl text-white font-bold mb-4 animate-fadeIn">
                  ¡Bienvenido!
                </h1>
                <p className="text-2xl tex-center text-gray-300 animate-fadeIn delay-500">
                  Comencemos con este modulo.
                  <p className="text-center">!Buena Suerte!</p>
                </p>
              </div>
            </div>
          ) : (
            <div className="exercise-screen flex flex-col items-center justify-center h-screen ">
              <div className="text-3xl text-center relative p-10 text-white animate-slideUp">
                <p
                  className={`text-shadow ${
                    incorrect ? "text-red-500" : "text-[#FCDE70]"
                  }`}
                >
                  I am Michel! I liked{" "}
                  <span className="underline">
                    {selectedWords.word1 || "___"}
                  </span>{" "}
                  and{" "}
                  <span className="underline">
                    {selectedWords.word2 || "___"}
                  </span>{" "}
                  in the park and I liked play video games in my computer gamer.
                </p>
              </div>

              <div className="flex justify-center items-center relative p-10 gap-5 animate-slideUp">
                <Button onClick={() => handleButtonClick("Play", "word1")}>
                  Play
                </Button>
                <Button onClick={() => handleButtonClick("Eat", "word1")}>
                  Eat
                </Button>
                <Button onClick={() => handleButtonClick("Running", "word2")}>
                  Running
                </Button>
                <Button onClick={() => handleButtonClick("Jump", "word2")}>
                  Jump
                </Button>
              </div>
            </div>
          )}
        </>
      ) : (
        <></>
      )}
    </>
  );
}

export default FillGapsExercises;
