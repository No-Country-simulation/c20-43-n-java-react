"use client";
import { useSession } from "next-auth/react";
import Home from "../page";

const page = () => {
  return (
    <div>
      <Home />
    </div>
  );
};
export default page;
