"use client";

import { useSession } from "next-auth/react";
import React, { useState, useEffect } from "react";
import Button from "./ButtonUI";

interface Exercise {
  text: string;
  gaps: { [key: string]: string };
  options: string[];
}

function FillGapsExercises() {
  const { data: session } = useSession();
  const [showContent, setShowContent] = useState<boolean>(false);
  const [currentExerciseIndex, setCurrentExerciseIndex] = useState(0);
  const [selectedWords, setSelectedWords] = useState<{ [key: string]: string }>(
    {}
  );
  const [incorrect, setIncorrect] = useState(false);

  const exercises: Exercise[] = [
    {
      text: "I am Michel! I liked ___ and ___ in the park.",
      gaps: { word1: "Play", word2: "Running" },
      options: ["Play", "Eat", "Running", "Jump"],
    },
    {
      text: "She enjoys ___ and ___ at the beach.",
      gaps: { word1: "Swimming", word2: "Playing volleyball" },
      options: ["Swimming", "Eating", "Jumping", "Playing volleyball"],
    },
    {
      text: " My brothers ___  football on  ___ .",
      gaps: { word1: "Watch", word2: "television" },
      options: ["Watch", "Football", "television", "Jump"],
    },
  ];

  const currentExercise = exercises[currentExerciseIndex];

  const handleButtonClick = (word: string, position: "word1" | "word2") => {
    if (word === currentExercise.gaps[position]) {
      setSelectedWords((prev) => ({ ...prev, [position]: word }));
      setIncorrect(false);

      if (Object.keys(selectedWords).length + 1 === Object.keys(currentExercise.gaps).length) {
        setTimeout(() => {
          setSelectedWords({});
          setCurrentExerciseIndex((prev) => (prev + 1) % exercises.length);
        }, 1000);
      }
    } else {
      setIncorrect(true);
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
            <div className="welcome-screen flex items-center justify-center h-[70px]">
              <div className="text-center">
                <h1 className="text-3xl sm:text-6xl text-white font-bold mb-4 animate-fadeIn">
                  ¡Bienvenido!
                </h1>
                <p className="text-xl sm:text-2xl text-gray-300 animate-fadeIn delay-500">
                  Este es el módulo de presentación.
                </p>
              </div>
            </div>
          ) : (
            <div className="exercise-screen flex flex-col items-center justify-center h-[100px]">
              <div className="text-xl sm:text-3xl text-center relative p-5 sm:p-10 text-white animate-slideUp">
                <p className={`text-shadow ${incorrect ? "text-red-500" : "text-[#FCDE70]"}`}>
                  {currentExercise.text.split("___").map((part, index) => (
                    <React.Fragment key={index}>
                      {part}
                      {index < Object.keys(currentExercise.gaps).length && (
                        <span className="underline">
                          {selectedWords[`word${index + 1}`] || "___"}
                        </span>
                      )}
                    </React.Fragment>
                  ))}
                </p>
              </div>

              <div className="flex justify-center items-center relative p-5 sm:p-10 gap-2 sm:gap-5 animate-slideUp">
                {currentExercise.options.map((option) => (
                  <Button
                    key={option}
                    onClick={() =>
                      handleButtonClick(
                        option,
                        `word${Object.keys(selectedWords).length + 1}` as "word1" | "word2"
                      )
                    }
                  >
                    {option}
                  </Button>
                ))}
              </div>
            </div>
          )}
        </>
      ) : null}
    </>
  );
}

export default FillGapsExercises;


