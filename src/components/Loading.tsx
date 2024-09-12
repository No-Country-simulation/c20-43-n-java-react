import React from "react";
import styled from "styled-components";

const Loading = () => {
  return (
    <StyledWrapper>
      <div className="spinner">
        <div />
        <div />
        <div />
        <div />
        <div />
        <div />
      </div>
    </StyledWrapper>
  );
};

const StyledWrapper = styled.div`
  .spinner {
    width: 20px;
    height: 20px;
    animation: spinner-y0fdc1 2s infinite ease;
    transform-style: preserve-3d;
  }

  .spinner > div {
    background-color: rgba(255, 20, 147, 0.2); /* Rosa translúcido */
    height: 100%;
    position: absolute;
    width: 100%;
    border: 2px solid rgba(255, 20, 147, 1); /* Rosa sólido */
  }

  .spinner div:nth-of-type(1) {
    transform: translateZ(-22px) rotateY(180deg);
  }

  .spinner div:nth-of-type(2) {
    transform: rotateY(-270deg) translateX(50%);
    transform-origin: top right;
  }

  .spinner div:nth-of-type(3) {
    transform: rotateY(270deg) translateX(-50%);
    transform-origin: center left;
  }

  .spinner div:nth-of-type(4) {
    transform: rotateX(90deg) translateY(-50%);
    transform-origin: top center;
  }

  .spinner div:nth-of-type(5) {
    transform: rotateX(-90deg) translateY(50%);
    transform-origin: bottom center;
  }

  .spinner div:nth-of-type(6) {
    transform: translateZ(22px);
  }

  @keyframes spinner-y0fdc1 {
    0% {
      transform: rotate(45deg) rotateX(-25deg) rotateY(25deg);
      border-color: rgba(255, 20, 147, 0.5); /* Rosa en el borde durante la animación */
    }

    50% {
      transform: rotate(45deg) rotateX(-385deg) rotateY(25deg);
      border-color: rgba(255, 20, 147, 0.8); /* Intensidad de rosa durante la animación */
    }

    100% {
      transform: rotate(45deg) rotateX(-385deg) rotateY(385deg);
      border-color: rgba(255, 20, 147, 1); /* Rosa sólido al finalizar */
    }
  }
`;


export default Loading;
