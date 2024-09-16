"use client";

import { SessionProvider } from "next-auth/react";
import { useState } from "react";
import { ProgressProvider } from "./ProgressUserProvider";

interface Props {
  children: React.ReactNode;
}

const SessionAuthProvider = ({ children }: Props) => {


  return (
  <SessionProvider>
    <ProgressProvider>{children}</ProgressProvider>
  </SessionProvider>
  )
};

export default SessionAuthProvider;
