"use client";

import { signIn, useSession } from "next-auth/react";
import { useRouter } from "next/navigation";
import React, { FC, useState } from "react";

export const LoginComponent = () => {
  const { data: session } = useSession();
  const [errors, setErrors] = useState<string[]>([]);
  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();
  const router = useRouter();

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    setErrors([]);

    const responseNextAuth = await signIn("credentials", {
      email,
      password,
      redirect: false,
    });

    if (responseNextAuth?.error) {
      setErrors(responseNextAuth.error.split(","));
      return;
    }

    router.push("/dashboard");
  };

  return (
    <>
      <div>
        <div className="flex flex-col justify-center items-center">
          <h1 className="relative text-2xl md:text-3xl 2xl:text-4xl text-white text-shadow-lg font-bold animate-fadeIn">
            Linguish
          </h1>
          <p className="relative text-lg md:text-xl 2xl:text-2xl text-gray-500 animate-fadeIn font-sans">
            BIENVENIDO
          </p>
          <p className="text-gray-400 relative text-base md:text-lg 2xl:text-xl animate-fadeIn font-light">
            Ingresa tus datos para continuar
          </p>

          <form
            onSubmit={handleSubmit}
            className="flex justify-center items-center flex-col w-full max-w-xs sm:max-w-sm md:max-w-md lg:max-w-lg"
          >
            <div className="w-full">
              <label
                htmlFor="email"
                className="text-start text-sm font-semibold text-gray-500 block"
              >
                Nombre de usuario o email
              </label>
              <input
                type="email"
                placeholder="Ingresa tu correo electrónico"
                name="email"
                className="w-full h-[40px] bg-pink-100 text-white form-control mb-2 px-4 bg-opacity-20 rounded-md"
                value={email}
                onChange={(event) => setEmail(event.target.value)}
              />

              <label
                htmlFor="password"
                className="text-start text-sm font-semibold text-gray-500 block"
              >
                Contraseña
              </label>
              <input
                type="password"
                placeholder="Ingresa tu contraseña"
                name="password"
                className="w-full h-[40px] bg-pink-200 text-white form-control mb-2 px-4 bg-opacity-20 rounded-md"
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
            </div>

            <div className="flex flex-col gap-3 pt-5 w-full">
              <button
                type="submit"
                className="w-full h-[35px] btn btn-primary bg-pink-100 text-white rounded-md bg-opacity-20"
              >
                Iniciar Sesión
              </button>

              <button
                type="button"
                className="flex justify-center items-center w-full h-[40px] btn btn-primary bg-gray-950 text-white rounded-md border-purple-300 border"
                onClick={() => signIn("google", { callbackUrl: "/dashboard" })}
              >
                <img
                  src="googleIcon.png"
                  alt="google.png"
                  className="h-6 w-6 mr-2"
                />
                Iniciar sesión con Google
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};
