import React from "react";

function About() {
  return (
    <>
      <p className=" relative 2xl:bottom-10 xl:bottom-20 animate-fadeIn text-4xl text-white text-shadow-lg font-bold  pb-10">
      ¿Quiénes somos?
      </p>
      <div>
        <div className="flex justify-center items-start text-center p-10 animate-fadeIn">
          <p className="text-xl animate-fadeIn font-light relative text-shadow-lg 2xl:bottom-12 xl:bottom-12">
            Somos un equipo de apasionados desarrolladores inspirados en mejorar
            la comunicacion en ingles para entornos de trabajo o entrevistas
            laborales extranjeras
          </p>
        </div>

        <div className="flex justify-center items-center gap-5 animate-fadeIn">
          <div className="w-32 h-32 ">
            <img
              className="rounded-full"
              src="crisPerezImage.jpg"
              alt="imagecris.jpg"
            />
          </div>
          <div className="w-32 h-32 ">
            <img className="rounded-full" src="crisImage.png" alt="crisA.png" />
          </div>
          <div className="w-32 h-32 ">
            <img
              className="rounded-full"
              src="joseMoralesImge.jpg"
              alt="joseM.png"
            />
          </div>
        </div>
      </div>
    </>
  );
}

export default About;
