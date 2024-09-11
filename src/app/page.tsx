"use client";

import Button from "@/components/ButtonUI";
import Dashboard from "@/components/Dashboard";
import Loading from "@/components/Loading";
import { signIn, signOut, useSession } from "next-auth/react";
// import Image from "next/image";

export default function Home() {
  const { data: session, status } = useSession();

  if (status === "loading") {
    return <Loading/>;
  }

  if (session) {
    return (
      <>
        <div>
          <Dashboard />
        </div>
      </>
    );
  }

  if (!session) {
    return (
      <>
        <div className="flex justify-center items-center flex-col">
          <h1 className="text-5xl text-white text-shadow-lg font-bold animate-fadeIn pb-10">Linguish</h1>

          <div className="text-center">
            <p className="text-xl pb-10 text-black font-light text-shadow-sm animate-fadeIn">
              Descubre una forma divertida y efectiva de aprender inglés. Con
              recursos interactivos y lecciones adaptadas a tu nivel, te
              ayudaremos a mejorar tu comprensión y fluidez en inglés. ¡Empieza
              tu viaje lingüístico con nosotros hoy mismo!
            </p>
          </div>
          {/* <div className="flex justify-center items-center gap-2 w-42 p-3 w-38 h-9 bg-pink-200 text-white rounded-md bg-opacity-20">
            <button onClick={() => signIn()} className="">
              Aprende ingles ahora
            </button>
            <img src="/arrow-right.png" alt="" />
          </div> */}
              <Button onClick={() => signIn()}>Aprende Ahora</Button>
        </div>
      </>
    );
  }
}
