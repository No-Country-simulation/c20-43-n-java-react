"use client";
import { useSession } from "next-auth/react";
import React from "react";

function NavWelcome() {
  const { data: session } = useSession();
  return (
    <>
      {session ? (
        <nav className="relative p-10 2xl:w-full 2xl:top-0 xl:top-20">
          <ul className="flex justify-center items-center">
            <li className="text-2xl">
              Bienvenido de nuevo {session?.user?.name}
            </li>
          </ul>
        </nav>
      ) : (
        <></>
      )}
    </>
  );
}

export default NavWelcome;
