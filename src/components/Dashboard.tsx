"use client";
import { useSession } from "next-auth/react";

const Dashboard = () => {
  const { data: session, status } = useSession();


  if (status === "loading") {
    return <p>Loading...</p>;
  }
  console.log(session);

  return (
    <>
      
    <div className="relative 2xl:top-0 xl:top-16">

      <div className="">
        <h1 className="text-2xl">Modulos</h1>
      </div>

      <div className="flex flex-col gap-5">
        <div className="bg-pink-200 bg-opacity-20 p-8 rounded-xl shadow-lg ">
          <strong>Clase 1</strong>
          <p>
            Comienza tu apredizaje con esta clase y potencia tu ingles como
            nunca
          </p>
          <img src="" alt="imagen.png" />
        </div>
        <div className="bg-pink-200 bg-opacity-20 p-8 rounded-xl shadow-lg ">
          <strong>Clase 1</strong>
          <p>
            Comienza tu apredizaje con esta clase y potencia tu ingles como
            nunca
          </p>
          <img src="" alt="imagen.png" />
        </div>
        <div className="bg-pink-200 bg-opacity-20  p-8 rounded-xl shadow-lg ">
          <strong>Clase 1</strong>
          <p>
            Comienza tu apredizaje con esta clase y potencia tu ingles como
            nunca
          </p>
          <img src="" alt="imagen.png" />
        </div>
      </div>
    </div>
    </>
  );
};
export default Dashboard;
