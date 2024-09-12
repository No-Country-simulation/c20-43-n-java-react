"use client";

import Button from "@/components/ButtonUI";
import Dashboard from "@/components/Dashboard";
import Loading from "@/components/Loading";
import { signIn, signOut, useSession } from "next-auth/react";
import { useRouter } from "next/navigation";

// import Image from "next/image";

export default function Home() {
  const router = useRouter()
  const { data: session, status } = useSession();

  if (status === "loading") {
    return <Loading />;
  }

  if (session) {
    return (
      <>
        <div>
          <Dashboard />
        </div>
      </>
    );
  }

  if (!session) {
    router.push("/login")
  } 
}
