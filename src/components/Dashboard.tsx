"use client";
import { useSession } from "next-auth/react";
// import FillGapsExersices from "./FillGapsExersices";
import Link from "next/link";
import Loading from "./Loading";

const Dashboard = () => {
  const { data: session, status } = useSession();

  if (status === "loading") {
    return <Loading />;
  }
  console.log(session);

  return (
    <>
      <div className="relative 2xl:top-0 xl:top-16">
        <div className="text-center relative 2xl:bottom-26 xl:bottom-28 lg:bottom-5">
          <h1 className="text-3xl font-semibold mb-3 animate-fadeIn">
            Modulos
          </h1>
          <div className="text-start">
            <p className="text-[20px] font-light mb-2 animate-fadeIn">
              Comienza los niveles desde principiante hasta un nivel avanzado!
            </p>
            <p className="text-[20px] font-light mb-2 animate-fadeIn">
              Ve desbloqueando modulos.
            </p>
          </div>
        </div>

        <div className="flex flex-col gap-5">
          <div className="bg-pink-200 bg-opacity-20 p-8 rounded-xl shadow-lg relative 2xl:bottom-10 xl:bottom-20">
            <Link href={"/lecture"}>
              <strong>Modulo 1</strong>
              <p>
                Comienza tu apredizaje con esta clase y potencia tu ingles como
                nunca
              </p>
              <img src="" alt="imagen.png" />
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};
export default Dashboard;
