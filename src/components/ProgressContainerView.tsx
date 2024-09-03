"use client";

import { useSession } from "next-auth/react";
import ProgressComponent from "./ProgressComponent";
import React from "react";

function ProgressContainerView() {
  const { data: session } = useSession();

  return (
    <>
      {session ? (
        <div className=" bg-pink-200 bg-opacity-40 backdrop-blur-lg p-8 rounded-lg shadow-lg max-w-screen-lg relative 2xl:top-8 xl:top-12 sm:w-[700px] w-[800px] h-20 pt-0">
          <ProgressComponent />
        </div>
      ) : (
        <></>
      )}
    </>
  );
}

export default ProgressContainerView;
