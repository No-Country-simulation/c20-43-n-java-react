import React from "react";
import styled from "styled-components";
import { signIn, signOut, useSession } from "next-auth/react";

interface PropsChildren {
  children: React.ReactNode;
  onClick?: () => void; 
  className?: any
}

const Button = ({children, onClick, className}: PropsChildren) => {
  return (
    <StyledWrapper>
      <button onClick={onClick} className={className}>
        <span className="button_top text-sm">{children}</span>
      </button>
    </StyledWrapper>
  );
};

const StyledWrapper = styled.div`
  button {
    /* Variables */
    --button_radius: 0.75em;
    --button_color: #e8e8e8;
    --button_outline_color: #000000;
    font-size: 17px;
    font-weight: bold;
    border: none;
    cursor: pointer;
    border-radius: var(--button_radius);
    background: var(--button_outline_color);
  }

  .button_top {
    display: block;
    box-sizing: border-box;
    border: 2px solid var(--button_outline_color);
    border-radius: var(--button_radius);
    padding: 0.75em 1.5em;
    background: var(--button_color);
    color: var(--button_outline_color);
    transform: translateY(-0.2em);
    transition: transform 0.1s ease;
  }

  button:hover .button_top {
    /* Pull the button upwards when hovered */
    transform: translateY(-0.33em);
  }

  button:active .button_top {
    /* Push the button downwards when pressed */
    transform: translateY(0);
  }
`;

export default Button;

/*

"use client";

import { useSession } from "next-auth/react";
import React, { useState, useEffect } from "react";
import Button from "./ButtonUI";

interface Exercise {
  text: string;
  gaps: { [key: string]: string }; // Las respuestas correctas para los espacios
  options: string[]; // Opciones de botones
}

function FillGapsExercises() {
  const { data: session } = useSession();
  const [showContent, setShowContent] = useState<boolean>(false);
  const [currentExerciseIndex, setCurrentExerciseIndex] = useState(0);
  const [selectedWords, setSelectedWords] = useState<{ [key: string]: string }>(
    {}
  );
  const [incorrect, setIncorrect] = useState(false);

  // Lista de ejercicios
  const exercises: Exercise[] = [
    {
      text: "I am Michel! I liked play ___ and ___ running in the park.",
      gaps: { word1: "Play", word2: "Running" },
      options: ["Play", "Eat", "Running", "Jump"]
    },
    {
      text: "She enjoys ___ and ___ at the beach.",
      gaps: { word1: "Swimming", word2: "Playing volleyball" },
      options: ["Swimming", "Eating", "Jumping", "Playing volleyball"]
    },
    // Puedes agregar más ejercicios aquí
  ];

  const currentExercise = exercises[currentExerciseIndex];

  const handleButtonClick = (word: string, position: "word1" | "word2") => {
    if (word === currentExercise.gaps[position]) {
      setSelectedWords((prev) => ({ ...prev, [position]: word }));
      setIncorrect(false); // Correcto, no hay error

      // Si el ejercicio está completo, pasar al siguiente
      if (Object.keys(selectedWords).length + 1 === Object.keys(currentExercise.gaps).length) {
        setTimeout(() => {
          // Limpiar las respuestas seleccionadas y avanzar al siguiente ejercicio
          setSelectedWords({});
          setCurrentExerciseIndex((prev) => (prev + 1) % exercises.length);
        }, 1000); // Espera 1 segundo antes de cambiar
      }
    } else {
      setIncorrect(true); // Respuesta incorrecta
      setTimeout(() => {
        setIncorrect(false);
      }, 1000); // Restablecer el error después de 1 segundo
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
                <p className="text-2xl text-gray-300 animate-fadeIn delay-500">
                  Este es el módulo de presentación.
                </p>
              </div>
            </div>
          ) : (
            <div className="exercise-screen flex flex-col items-center justify-center h-screen">
              <div className="text-3xl text-center relative p-10 text-white animate-slideUp">
                <p
                  className={`text-shadow ${
                    incorrect ? "text-red-500" : "text-[#FCDE70]"
                  }`}
                >
                  {/* Insertamos la frase actual *
//                   {currentExercise.text.split("___").map((part, index) => (
//                     <>
//                       {part}
//                       <span className="underline">
//                         {selectedWords[`word${index + 1}`] || "___"}
//                       </span>
//                     </>
//                   ))}
//                 </p>
//               </div>

//               <div className="flex justify-center items-center relative p-10 gap-5 animate-slideUp">
//                 {currentExercise.options.map((option) => (
//                   <Button
//                     key={option}
//                     onClick={() => handleButtonClick(option, `word${Object.keys(selectedWords).length + 1}` as "word1" | "word2")}
//                   >
//                     {option}
//                   </Button>
//                 ))}
//               </div>
//             </div>
//           )}
//         </>
//       ) : (
//         <></>
//       )}
//     </>
//   );
// }

// export default FillGapsExercises;


*/