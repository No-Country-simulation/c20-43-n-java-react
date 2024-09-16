"use client";

import Button from "@/components/ButtonUI";
import Dashboard from "@/components/Dashboard";
import Loading from "@/components/Loading";
import { LoginComponent } from "@/components/LoginComponent";
import { signIn, signOut, useSession } from "next-auth/react";
import { useRouter } from "next/navigation";
import { useState } from "react";



export default function Home() {
  const [active, setActive] = useState(false)
  const router = useRouter();
  const { data: session, status } = useSession();

  if (status === "loading") {
    return <Loading />;
  }

  if (session) {
    return (
      <>
        <div>
          <Dashboard setActive={setActive}/>
        </div>
      </>
    );
  } 

  if(!session) {
    return (
      <LoginComponent/>
    )
  }
}
