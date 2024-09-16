import React from "react";

function PresentModule() {
  return (
    <>
      <div className="welcome-screen flex items-center justify-center h-screen">
        <div className="text-center">
          <h1 className="text-6xl text-white font-bold mb-4 animate-fadeIn">
            ¡Bienvenido!
          </h1>
          <p className="text-2xl text-gray-300 animate-fadeIn delay-500">
            Buena suerte con los ejercicios :D
          </p>
        </div>
      </div>
    </>
  );
}

export default PresentModule;
