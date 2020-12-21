import styled from "styled-components";

export const TextViewContainer = styled.div`
  display: flex;
  flex-flow: column;
  background: #2f7dcd;
  .phoneBtn {
    width: 92%;
    left: 0;
    bottom: 0;
    margin: 7px 4%;
    margin-bottom: calc(7px + constant(safe-area-inset-bottom));
    margin-bottom: calc(7px + env(safe-area-inset-bottom));
  }
`;
export const Container = styled.div`
  background: #2f7dcd;
`;

// Create a Title component that'll render an <h1> tag with some styles
export const Title = styled.label`
  font-size: 12sp;
  text-align: center;
  color: palevioletred;
`;

// Create a Wrapper component that'll render a <section> tag with some styles
export const Wrapper = styled.section`
  padding: 10px;
  background: papayawhip;
`;

// Create an Input component that'll render an <input> tag with some styles
export const Input = styled.input`
  padding: 0.5em;
  margin: 0.5em;
  color: palevioletred;
  background: papayawhip;
  border: none;
  border-radius: 3px;
`;

export const Button = styled.button`
  background: ${(props: { primary: boolean }) =>
    props.primary ? "palevioletred" : "white"};
  color: ${(props: { primary: boolean }) =>
    props.primary ? "white" : "palevioletred"};
  font-size: 1em;
  margin: 1em;
  padding: 0.25em 1em;
  border: 2px solid palevioletred;
  border-radius: 3px;
`;
