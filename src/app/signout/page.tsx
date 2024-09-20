"use client";

import { signOut } from "next-auth/react";
import Link from "next/link";
import React from "react";

function page() {
  return (
    <div>
      <h1 className="text-gray-300 ">Seguro que quieres Cerrar session? </h1>
      <div className="flex mt-4 gap-3 justify-center items-center">
        <Link href="/">
          <button onClick={() => signOut({ callbackUrl: "/" })}>Cerrar</button>
        </Link>
        <Link href="/dashboard">
          <button>Volver</button>
        </Link>
      </div>
    </div>
  );
}

export default page;
