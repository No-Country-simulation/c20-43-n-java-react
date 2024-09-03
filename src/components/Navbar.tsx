"use client"

import React from "react";
import { signIn, signOut, useSession } from "next-auth/react";


const Navbar = () => {
    const {data: session} = useSession()

  return (
    <>
      <nav className="flex justify-between bg-pink-200 bg-opacity-40 backdrop-blur-lg p-8 shadow-lg">
        <ul className="flex gap-10 justify-center items-center">
          <li className="text-3xl font-medium px-10">
            <a href="">Linguish</a>
          </li>
          <li>
            <a href="">Inicio</a>
          </li>
          <li className="">
            <a href="">Sobre Nosotros</a>
          </li>
          <li className="">
            <a href="">Rutas</a>
          </li>
        </ul>
        
        <ul className="flex gap-10 justify-center items-center px-10">
          <li>
            <a href="">Ajustes</a>
          </li>
          {
            session ? <li><a href="">{session.user?.email}</a></li> : <span className="flex justify-center items-center w-32 h-9 bg-pink-100 text-white rounded-md  bg-opacity-20"><li><a href="">Iniciar Sesion</a></li></span>
          }
          
        </ul>
      </nav>
    </>
  );
};

export default Navbar;
