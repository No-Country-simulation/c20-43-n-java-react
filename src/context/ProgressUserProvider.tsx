import { createContext, ReactNode, useContext, useState } from "react";


interface ProgressContextType {
    percent: number;
    increaseProgress: () => void;
    setPercent: (value: number) => void
  }
  
  const ProgressContext = createContext<ProgressContextType | undefined>(undefined);
  
  export const useProgress = () => {
    const context = useContext(ProgressContext);
    if (!context) {
      throw new Error("useProgress debe ser usado dentro de un ProgressProvider");
    }
    return context;
  };
  
  interface ProgressProviderProps {
    children: ReactNode;
  }
  
  export const ProgressProvider = ({ children }: ProgressProviderProps) => {
    const [percent, setPercent] = useState(0);
  
    const increaseProgress = () => {
      setPercent((prev) => Math.min(prev + 10, 100));
    };
  
    return (
      <ProgressContext.Provider value={{ percent, increaseProgress, setPercent }}>
        {children}
      </ProgressContext.Provider>
    );
  };