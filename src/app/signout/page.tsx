"use client";

import { signOut } from "next-auth/react";
import Link from "next/link";
import React from "react";

function page() {
  return (
    <div>
      <h1>Seguro que quieres Cerrar session?    </h1>
      <div className="flex flex-col justify-center items-center">
        <button onClick={() => signOut({callbackUrl: '/'})}>Cerrar</button>
        <Link href="/dashboard">
          <button>Volver</button>
        </Link>
      </div>
    </div>
  );
}

export default page;
