"use client";

import { useSession } from "next-auth/react";
import React from "react";
import { ProgressComponent } from "./ProgressComponent";

function ProgressContainerView() {
  const { data: session } = useSession();

  return (
    <>
      {session ? (
        <div className=" bg-pink/60 border-purple-300 border text-white backdrop-blur-lg  p-2 rounded-lg shadow-lg relative 2xl:top-8 xl:top-12 w-[400px] h-20 pt-0">
          <ProgressComponent />
        </div>
      ) : (
        <></>
      )}
    </>
  );
}

export default ProgressContainerView;
