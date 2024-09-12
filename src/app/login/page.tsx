"use client";

import { signIn } from "next-auth/react";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { useState } from "react";

const LoginPage = () => {
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
    <div>
      <div>
        <div className="flex flex-col justify-center items-center">
          <h1 className="relative 2xl:bottom-14 xl:bottom-14 text-4xl text-white text-shadow-lg font-bold animate-fadeIn">
            Linguish
          </h1>
          <p className="relative 2xl:bottom-10 xl:bottom-10 text-2xl text-gray-900 animate-fadeIn font-sans">
            BIENVENIDO
          </p>
          <p className="relative 2xl:bottom-9 xl:bottom-10 animate-fadeIn text-xl font-light">
            Ingresa tus datos para continuar
          </p>
          <form
            onSubmit={handleSubmit}
            className="flex justify-center items-center flex-col "
          >
            <div className="">
              <label
                htmlFor=""
                className="text-start text-sm font-semibold text-gray-950 "
              >
                Nombre de usuario o email
              </label>
              <input
                type="email"
                placeholder="Ingresa tu correo electronico"
                name="email"
                className="2xl:w-[25rem] xl:w-[25rem] 2xl:h-[45px] xl:h-[45px] bg-pink-100 text-white form-control mb-2 flex px-4 bg-opacity-20 rounded-md "
                value={email}
                onChange={(event) => setEmail(event.target.value)}
              />
              <label
                htmlFor=""
                className="text-start text-sm font-semibold text-gray-950 "
              >
                Contraseña
              </label>
              <input
                type="password"
                placeholder="Ingresa tu contraseña"
                name="password"
                className="2xl:w-[25rem] xl:w-[25rem] 2xl:h-[45px] xl:h-[45px] bg-pink-200 form-control mb-2 flex px-4 rounded-md h-8 bg-opacity-20 "
                value={password}
                onChange={(event) => setPassword(event.target.value)}
              />
            </div>
            <div className="flex flex-col relative gap-3 pt-5 2xl:top-3">
              <button
                type="submit"
                className="2xl:w-[25rem] xl:w-[25rem] 2xl:h-[40px] xl:h-[40px] btn btn-primary w-32 h-9 bg-pink-100 text-white rounded-md bg-opacity-20"
              >
                Iniciar Sesion
              </button>
              <button
                className="flex justify-center items-center 2xl:w-[25rem] xl:w-[25rem] 2xl:h-[40px] xl:h-[40px] btn btn-primary w-32 h-9 bg-gray-950 text-white rounded-md border-purple-300 border"
                onClick={async () => {
                  const responseGoogleAuth = await signIn("google", {
                    redirect: false,
                  });
                  if (!responseGoogleAuth?.error) {
                    router.push("/dashboard");
                  }
                }}
              >
                <img
                  src="googleIcon.png"
                  alt="google.png"
                  className="h-8 w-8 p-1"
                />
                Iniciar sesión con Google
              </button>
            </div>
          </form>

          {errors.length > 0 && (
            <div className="alert alert-danger mt-2">
              <ul className="mb-0">
                {errors.map((error) => (
                  <li key={error}>{error}</li>
                ))}
              </ul>
            </div>
          )}
        </div>
      </div>
    </div>
  );
};
export default LoginPage;
