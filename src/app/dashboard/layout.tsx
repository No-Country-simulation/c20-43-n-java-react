import Navbar from "@/components/Navbar";
import React, { ReactNode } from "react";

interface ChildrenProps {
  children: ReactNode;
}

function LayoutHome({ children }: ChildrenProps) {
  return (
    <div>
      {children}
    </div>
  );
}

export default LayoutHome;
