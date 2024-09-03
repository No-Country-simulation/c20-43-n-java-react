"use client";

import { useSession } from "next-auth/react";
import ProgressComponent from "./ProgressComponent";
import React from "react";

function ViewProgress() {
  const { data: session } = useSession();

  return (
    <>
      {session ? (
        <div className=" bg-pink-200 bg-opacity-40 backdrop-blur-lg p-8 rounded-lg shadow-lg max-w-screen-lg w-[800px] h-20 pt-0 relative lg:top-5">
          <ProgressComponent />
        </div>
      ) : (
        <></>
      )}
    </>
  );
}

export default ViewProgress;
