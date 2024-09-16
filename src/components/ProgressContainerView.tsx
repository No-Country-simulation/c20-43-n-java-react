"use client";

import { useSession } from "next-auth/react";
import React from "react";
import { ProgressComponent } from "./ProgressComponent";

function ProgressContainerView() {
  const { data: session } = useSession();

  return (
    <>
      {session ? (
        <div className=" bg-gradient-to-r bg-pink-300 backdrop-blur-sm bg-opacity-50  p-8 rounded-lg shadow-lg max-w-screen-lg relative 2xl:top-8 xl:top-12 sm:w-[700px] w-[800px] h-20 pt-0">
          <ProgressComponent />
        </div>
      ) : (
        <></>
      )}
    </>
  );
}

export default ProgressContainerView;
