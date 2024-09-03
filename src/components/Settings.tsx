"use client"

import {  signOut } from "next-auth/react";
import Image from "next/image";
import Link from "next/link";


function Settings() {

  return (
    <>
    <div className="flex relative right-[350px]">
        <Link href="/dashboard">
          <img src="./arrow-left2.png" alt="arrow-left" className="h-8 w-8" />
        </Link>
      </div>
      <ul className="relative 2xl:bottom-32 xl:bottom-5 lg:bottom-5 md:bottom-14 sm:bottom-14" >
        <li className="flex justify-center items-center bg-white rounded-full h-32 w-32">
          <Image src="/user01.png" alt="user" width={50} height={60}  priority quality={75} />
        </li>
      </ul>
      <ul className="relative lg:mt-10">
        <div>
          <label htmlFor="">Usuario</label>
          <input type="text" placeholder="Cambiar usuario" />
        </div>
        <div>
          <label htmlFor="">Correo electronico</label>
          <input type="text" placeholder="Cambiar correo" />
        </div>
        <div>
          <label htmlFor="">Contrasena</label>
          <input type="text" placeholder="Cambiar contrasena" />
        </div>

        <button onClick={() => signOut()} className="">
            Cerrar Sesion
        </button>
      </ul>
    </>
  );
}

export default Settings;
