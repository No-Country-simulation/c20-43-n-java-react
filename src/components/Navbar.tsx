"use client";

import React, { useState } from "react";
import { signIn, signOut, useSession } from "next-auth/react";

import Image from "next/image";
import Link from "next/link";

const Navbar = () => {
  const { data: session } = useSession();
  const [isOpen, setIsOpen] = useState(false);
  const toggleMenu = () => {
    setIsOpen(true);

    setTimeout(() => {
      setIsOpen(false);
    }, 2000);
  };

  return (
    <>
     {
     session ? (
      <nav className="flex justify-between bg-pink-200 bg-opacity-40 backdrop-blur-lg p-8 shadow-lg">
        <ul className="flex gap-10 justify-center items-center">
          <li className=" px-10 ">
            <a className="text-4xl text-white text-shadow-lg font-bold animate-fadeIn pb-10">
              Linguish
            </a>
          </li>
          <li className="animate-fadeIn text-shadow-sm">
            <a href="/dashboard">Inicio</a>
          </li>
          <li className="animate-fadeIn text-shadow-sm">
            <a href="/sobreNosotros">Sobre Nosotros</a>
          </li>
          {/* <Link href={"/rutas"}> */}
          <li className="animate-fadeIn text-shadow-sm">
            <a href="/rutas">Rutas</a>
          </li>
          {/* </Link> */}
        </ul>

        <ul className="flex gap-10 justify-center items-center px-10">
          <Link href={session ? "/settings" : "/"}>
            <li className="relative">
              <span className="group inline-block">
                <Image
                  src={"/settings01.png"}
                  width={50}
                  height={50}
                  alt="image-settings"
                  className="cursor-pointer group-hover:rotate-180 transition-transform duration-500 animate-fadeIn"
                />
              </span>
            </li>
          </Link>

          {/* {session ? (
            

              
            </li>
          ) : (
            <></>
          )} */}

          {session ? (
            <li className="">
              <span
                onClick={toggleMenu}
                className="cursor-pointer flex justify-center items-center"
              >
                {session.user?.email}
                <svg
                  className={`ml-2 transition-transform ${
                    isOpen ? "rotate-180" : ""
                  }`}
                  width="10"
                  height="10"
                  fill="currentColor"
                >
                  <path d="M0 0l5 5 5-5H0z" />
                </svg>
                {isOpen && (
                  <div className="absolute right-10 mt-52 w-48 bg-white border border-gray-200 rounded shadow-lg">
                    <ul>
                      <li className="px-4 py-2 hover:bg-gray-100 cursor-pointer">
                        Mi Perfil
                      </li>
                      <li className="px-4 py-2 hover:bg-gray-100 cursor-pointer">
                        Configuracion
                      </li>
                      <li className="px-4 py-2 hover:bg-gray-100 cursor-pointer">
                        <button
                          onClick={() => signOut()}
                          className="btn btn-danger"
                        >
                          Cerrar Sesion
                        </button>
                      </li>
                    </ul>
                  </div>
                )}
              </span>
            </li>
          ) : (
            <span className="flex justify-center items-center w-32 h-9 bg-pink-100 text-white rounded-md animate-fadeIn bg-opacity-20">
              <li>
                <a href="/login">Iniciar Sesion</a>
              </li>
            </span>
          )}
        </ul>
      </nav>   
     ) : <></>
     }
    </>
  );
};

export default Navbar;
