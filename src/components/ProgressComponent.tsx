"use client";

import React, { useState } from "react";
import { Progress, Button } from "antd";

const ProgressComponent: React.FC = () => {
  const [percent, setPercent] = useState(0);

  const increaseProgress = () => {
    setPercent((prev) => Math.min(prev + 10, 100));
  };

  return (
    <div className="p-3">
      <h1>Mi progreso</h1>
      <Progress percent={percent} strokeColor="#FF8C9E" className="" />
      {/* <Button onClick={increaseProgress} className="mt-4">
        Increase Progress
      </Button> */}
    </div>
  );
};

export default ProgressComponent;
