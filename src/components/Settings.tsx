"use client";

import { signOut } from "next-auth/react";
import Image from "next/image";
import Link from "next/link";

function Settings() {
  return (
    <>
      <div className="flex relative 2xl:right-[460px] 2xl:bottom-20 xl:right-[400px] ">
        <Link href="/dashboard">
          <img src="./arrow-left2.png" alt="arrow-left" className="h-8 w-8" />
        </Link>
      </div>
      <ul className="relative 2xl:bottom-20 xl:bottom-5 lg:bottom-5 md:bottom-14 sm:bottom-14">
        <li className="flex justify-center items-center bg-white rounded-full h-24 w-24">
          <Image
            src="/user01.png"
            alt="user"
            width={40}
            height={60}
            priority
            quality={75}
          />
        </li>
      </ul>

      <ul className="flex flex-col relative justify-center items-center">
        <div className="flex flex-col">
          <label htmlFor="">Usuario</label>
          <input className="bg-pink-100 text-white form-control mb-2 flex px-4 h-8 bg-opacity-20 rounded-md" type="text" placeholder="Cambiar usuario" />
        </div>
        <div className="flex flex-col">
          <label htmlFor="">Correo electronico</label>
          <input className="bg-pink-100 text-white form-control mb-2 flex px-4 h-8 bg-opacity-20 rounded-md" type="text" placeholder="Cambiar correo" />
        </div>
        <div className="flex flex-col">
          <label htmlFor="">Contrasena</label>
          <input className="bg-pink-100 text-white form-control mb-2 flex px-4 h-8 bg-opacity-20 rounded-md" type="text" placeholder="Cambiar contrasena" />
        </div>

        <button
          onClick={() => signOut()}
          className="flex justify-center items-center w-32 h-9 bg-pink-100 text-white rounded-md  bg-opacity-20"
        >
          Cerrar Sesion
        </button>
      </ul>
    </>
  );
}

export default Settings;
