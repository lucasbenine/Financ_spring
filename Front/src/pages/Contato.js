import React from 'react';

import styled from 'styled-components';
import Navbar from '../components/Navbar';

const Container = styled.div`
    width: 100vw;
    height: 92vh;
    display: flex;
    justify-content: center;
    align-items: center;

    .mb {
        margin-bottom: clamp(60px, 90px, 25%);
    }


    @media(max-width: 700px) {

        .mb {
            /* margin-bottom: clamp(25px, 45px, 60%); */
            margin-bottom: clamp(15%, 20%, 25%);
        }

        .box {
            flex-direction: column;
            height: 80%;

            div#esquerda {
                width: 100%;
                height: 70%;
                padding: 10%;
                border-right: none;

                form {
                    margin-bottom: 5px;
                }
            }

            div#direita {
                width: 100%;
                height: 30%;
                padding-top: 0;

                textarea {
                    height: 80%;
                    padding: 0 10%;
                }

                button {
                    height: 20%;
                }
            }
        }
    }
`;

const Box = styled.div`
    width: min(80%, 1200px);
    height: 60%;
    display: flex;
    background-color: #FFF;

    div#esquerda {
        width: 45%;
        height: 100%;
        padding: 5%;
        border-right: 1px solid rgba(0,0,0,.2);

        h1 {
            margin-bottom: 15px;
            font-size: clamp(1em, 1.8em, 2.2em);
        }

        hr {
            width: 40%;
            height: 3px;
            background: #04660E;
            border: none;
            border-radius: 5px;
            /* margin-bottom: clamp(60px, 90px, 25%); */
        }

        input#checkbox {
            margin-right: 15px;
        }
    }

    div#direita {
        width: 55%;
        height: 100%;
        padding-top: 5%;

        textarea {
            width: 100%;
            height: 90%;
            padding: 0 5%;
            border: none;
            font-size: 18px;
            resize: none;
            outline: none;
        }

        button {
            width: 100%;
            height: 10%;
            background: #000;
            color: #FFF;
            border: none;
            margin-top: -5px;
            font-weight: bold;
        }

    }

`;

const Input = styled.div`

    position: relative;
    animation-delay: 300ms;
    /* margin-bottom: clamp(60px, 90px, 25%); */

    input {
        position: relative;
        width: 100%;
        height: 25px;
        border: none;
        border-bottom: 2px solid rgba(0,0,0,.6);
        outline: none;
        border-radius: 0;
    }

    label {
        color: rgba(0,0,0,.6);
        position: absolute;
        left: 0;
        display: inline-block;
        pointer-events: none;
        transition: 0.5s;
    }

    input:focus ~ label,
    input:valid ~ label {
        transform: translateY(-24px);
        color: #04660E;
        font-size: 10pt;
    }

    input:focus,
    input:valid {
        border-bottom: 2px solid #04660E;
    }
`;

function Contato() {
  return (
      <>
        <Navbar />
        <Container>
            <Box className="box">
                <div id="esquerda">
                    <h1>Contate-nos</h1>
                    <hr className="mb" />

                    <form>
                        <Input className="mb">
                            <input type="text" required="require" />
                            <label>Nome</label>
                        </Input>
                        <Input className="mb">
                            <input type="text" required="require" />
                            <label>E-mail</label>
                        </Input>

                        <div >
                            <input type="checkbox" id="checkbox"/>
                            <label>Não sou um robô</label>
                        </div>
                    </form>
                </div>
                <div id="direita">
                    <textarea placeholder="Mensagem" />

                    <button>Enviar mensagem</button>
                </div>
            </Box>
        </Container>
      </>
  );
}

export default Contato;