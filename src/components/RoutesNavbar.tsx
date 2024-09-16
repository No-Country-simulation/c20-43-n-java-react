import React from "react";

function RoutesNavbar() {
  return (
    <>
      <p className="relative 2xl:bottom-10 xl:bottom-20 animate-fadeIn text-4xl text-white text-shadow-lg font-bold  pb-10">
        Nustras rutas!
      </p>
      <div className="flex justify-center items-center text-center animate-fadeIn gap-20">
        <div>
          <strong className="text-lg text-white text-shadow-lg font-bold animate-fadeIn pb-10">Nivel 1</strong>
          <p className="animate-fadeIn">Ingles Principiante I</p>
          <p className="animate-fadeIn">Comienza como todo un ganador </p>
        </div>
        <div>
          <strong className="text-lg text-white text-shadow-lg font-bold animate-fadeIn pb-10">Nivel 2</strong>
          <p className="animate-fadeIn">Ingles Principiante II</p>
          <p className="animate-fadeIn">Comienza como todo un ganador </p>
        </div>
      </div>
    </>
  );
}

export default RoutesNavbar;
