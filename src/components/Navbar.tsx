"use client";

import React, { useState } from "react";
import { signIn, signOut, useSession } from "next-auth/react";

import Image from "next/image";

const Navbar = () => {
  const { data: session } = useSession();
  const [isOpen, setIsOpen] = useState(false);
  // const toggleMenu = () => {
  //   setIsOpen(!isOpen);
  // };

  return (
    <>

        <div className="container mx-auto px-6 py-3 flex flex-col justify-center items-center sm:flex-row sm:justify-between pt-5">
          <a
            href="/"
            className="text-3xl font-bold text-white text-shadow text-center sm:text-left"
          >
            Linguish
          </a>

          <div className="hidden md:flex space-x-6 ">
            <a
              href="/dashboard"
              className="text-lg text-white hover:text-gray-300 transition-colors "
            >
              Inicio
            </a>
            <a
              href="/sobreNosotros"
              className="text-lg text-white hover:text-gray-300 transition-colors "
            >
              Sobre Nosotros
            </a>
            <a
              href="/rutas"
              className="text-lg text-white hover:text-gray-300 transition-colors "
            >
              Rutas
            </a>
          </div>
          {/* <div className="flex items-center space-x-4">
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
            </Link> */}

          {/* {session ? (
            

              
            </li>
          ) : (
            <></>
          )} */}
          {session ? (
            <div className="flex items-center space-x-4">
              {/* <FaCog className="text-white text-2xl cursor-pointer hover:text-gray-300 transition-colors" /> */}
              <div className="relative group">
                <span className="text-lg text-white cursor-pointer hidden items-center gap-5 sm:flex">
                  {session.user?.email}
                  <img src={`${session.user?.image}`} alt="profile.png" className="h-10 w-10 rounded-full"/>
                </span>
                {/* Dropdown para el email */}
                <div className=" absolute right-0 hidden group-hover:block bg-black border-purple-300 border text-white shadow-md rounded-lg py-2 w-48">
                  <a
                    href="/settings"
                    className="block px-4 py-2 hover:bg-gray-100 hover:text-black cursor-pointer"
                  >
                    Perfil
                  </a>
                  <a
                    onClick={() => signOut()}
                    className="block px-4 py-2 hover:text-black hover:bg-red-500 cursor-pointer"
                  >
                    Cerrar Sesión
                  </a>
                </div>
              </div>
            </div>
          ) : (
            <></>
          )}
        </div>
      {/* </nav> */}
    </>
  );
};

export default Navbar;

{
  /* Links */
}

//   <a
//     href="/"
//     className="text-lg text-white hover:text-gray-300 transition-colors"
//   >
//     Inicio
//   </a>
//   <a
//     href="/about"
//     className="text-lg text-white hover:text-gray-300 transition-colors"
//   >
//     Sobre Nosotros
//   </a>
//   <a
//     href="/routes"
//     className="text-lg text-white hover:text-gray-300 transition-colors"
//   >
//     Rutas
//   </a>
// </div>

// {/* Icono de configuraciones y usuario */}
// {/* <div >
//   <FaCog className="text-white text-2xl cursor-pointer hover:text-gray-300 transition-colors" />
// <div className="relative group">
//   <span className="text-lg text-white cursor-pointer">
//     jd3285201@gmail.com
//   </span>
//   {/* Dropdown para el email */}
//   <div className="absolute right-0 hidden group-hover:block bg-white text-black shadow-md rounded-lg mt-2 py-2 w-48">
//     <a href="/profile" className="block px-4 py-2 hover:bg-gray-100">
//       Perfil
//     </a>
//     <a href="/logout" className="block px-4 py-2 hover:bg-gray-100">
//       Cerrar Sesión
//     </a>
//   </div>
// </div> */}
