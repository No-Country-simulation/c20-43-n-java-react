"use client";

import Dashboard from "@/components/Dashboard";
import ProgressComponent from "@/components/ProgressComponent";
import { signIn, signOut, useSession } from "next-auth/react";
import Image from "next/image";

export default function Home() {
  const { data: session, status } = useSession();

  if (status === "loading") {
    return <p>Loading...</p>;
  }

  if (session) {
    return (
      <>
        <div >
          <Dashboard />
        </div>
      </>
    );
  }

  if (!session) {
    return (
      <div className="flex justify-center items-center flex-col">
        <h1 className="text-4xl font-medium pb-10">Linguish</h1>

        <div className="text-center">
          <p className="text-xl pb-10 text-black">
            Descubre una forma divertida y efectiva de aprender inglés. Con
            recursos interactivos y lecciones adaptadas a tu nivel, te
            ayudaremos a mejorar tu comprensión y fluidez en inglés. ¡Empieza tu
            viaje lingüístico con nosotros hoy mismo!
          </p>
        </div>
        <div className="flex justify-center items-center gap-2 w-42 p-3 w-38 h-9 bg-pink-200 text-white rounded-md bg-opacity-20">
          <button onClick={() => signIn()} className="">
            Aprende ingles ahora
          </button>
          <img src="/arrow-right.png" alt="" />
        </div>
      </div>
    );
  }
}
