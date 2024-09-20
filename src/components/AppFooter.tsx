import { Footer } from "antd/es/layout/layout";
import React, { ComponentProps } from "react";

type CustomPropsFooter = ComponentProps<typeof Footer>;

export default function AppFooter() {
  return (
    <div>
      <p className="text-[13px] text-gray-300">© Integral TeamDevs - 2024</p>
      <p className="text-[16px] text-gray-200 px-3">Linguish</p>
    </div>
  );
}
