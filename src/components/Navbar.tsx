"use client";

import React, { useState } from "react";
import { signIn, signOut, useSession } from "next-auth/react";

import Image from "next/image";
import Link from "next/link";

const Navbar = () => {
  const { data: session } = useSession();
  const [isOpen, setIsOpen] = useState(false);
  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  return (
    <>
      <nav className="flex justify-between bg-pink-200 bg-opacity-40 backdrop-blur-lg p-8 shadow-lg">
        <ul className="flex gap-10 justify-center items-center">
          <li className="text-3xl font-medium px-10">
            <a href="/dashboard">Linguish</a>
          </li>
          <li>
            <a href="/dashboard">Inicio</a>
          </li>
          <li className="">
            <a href="">Sobre Nosotros</a>
          </li>
          <li className="">
            <a href="">Rutas</a>
          </li>
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
                  className="cursor-pointer group-hover:rotate-180 transition-transform duration-500"
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
            <li>
              <span onClick={toggleMenu} className="cursor-pointer">
                {session.user?.email}
              </span>
              {isOpen && (
                <div className="absolute right-10 mt-3 w-48 bg-white border border-gray-200 rounded shadow-lg">
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
            </li>
          ) : (
            <span className="flex justify-center items-center w-32 h-9 bg-pink-100 text-white rounded-md  bg-opacity-20">
              <li>
                <a href="/login">Iniciar Sesion</a>
              </li>
            </span>
          )}
        </ul>
      </nav>
    </>
  );
};

export default Navbar;
