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
      <div className="absolute top-10 flex justify-start items-start pr-[900px]">
        <Link href="/">
          <img src="./arrow-left2.png" alt="arrow-left" className="h-8 w-8" />
        </Link>
      </div>
          <h1 className="text-4xl font-bold pb-8">Linguish</h1>
          <p className="text-[23px] pb-5">Iniciar Sesion</p>
          <form
            onSubmit={handleSubmit}
            className="flex justify-center items-center flex-col "
          >
            <input
              type="email"
              placeholder="Correo electronico"
              name="email"
              className="bg-pink-100 text-white form-control mb-2 flex px-4 h-8 bg-opacity-20 rounded-md"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
            />
            <input
              type="password"
              placeholder="Contrasena"
              name="password"
              className="bg-pink-200 form-control mb-2 flex px-4 rounded-md h-8 bg-opacity-20"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
            />

            <div className="pt-5">
              <button
                type="submit"
                className="btn btn-primary w-32 h-9 bg-pink-100 text-white rounded-md bg-opacity-20"
              >
                Iniciar Sesion
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
