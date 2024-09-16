"use client";

import React, { useEffect } from "react";
import { Progress, Button } from "antd";
import { useProgress } from "@/context/ProgressUserProvider";
import { progress } from "@/app/pages";
// Asegúrate de usar la ruta correcta para tu contexto

export const ProgressComponent: React.FC = () => {
  const { percent, increaseProgress, setPercent } = useProgress(); // Acceder al contexto



  return (
    <div className="p-3">
      <h1>Mi progreso</h1>
      <Progress percent={percent} strokeColor="#FF8C9E" className="" />
    </div>
  );
};