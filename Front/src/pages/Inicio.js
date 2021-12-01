/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState } from 'react';
import styled from 'styled-components';
import Modal from '../components/Modal';

const Container = styled.div`
    width: min(85vw, 1400px);
    margin: 0 auto;
    height: 100vh;
    font-size: 18px;
    padding: 40px 0;

    .border-green {
        border: 1px solid #00DC88;
    }

    .border-red {
        border: 1px solid #FE6161;
    }
`;

const Top = styled.div`

    width: 100%;
    display: flex;
    justify-content: space-between;

    div#saldo {
        background-color: #00DC88;
        width: 49%;
        height: 150px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: center;

        h3 {
            margin-bottom: 20px;
        }
    }

    div#buttons {
        width: 49%;
        display: flex;
        flex-direction: column;
        justify-content: space-between;

        button {
            width: 100%;
            padding: 20px 0;
            font-size: 20px;
            font-weight: 600;
            background: transparent;
            border: none;
            cursor: pointer;
        }
    }
`;

const Contas = styled.div`
    width: 100%;
    display: flex;
    justify-content: space-between;
    margin: 40px 0;

    div {
        width: 49%;
        padding: 10px 20px;

        h3 {
            text-align: center;
            margin-bottom: 20px
        }

        tr {
            width: 100%;
            display: flex;
            justify-content: space-between;
        }
    }
`;

function inicio() {

    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);


  return (
      <Container>
          <Top>
            <div id="saldo">
                <h3>Saldo estimado em conta:</h3>
                <h1>R$ 2515,00</h1>
            </div>
            <div id="buttons">
                <button style={{border:'1px solid #00CD88'}}>Adicionar entrada</button>
                <button style={{border:'1px solid #FE6161'}} onClick={() => setShowModal(true)} >Adicionar despesa</button>
            </div>
          </Top>
          <Contas>
              <div  className="border-green">
                <h3>Contas a receber</h3>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
              </div>
              <div className="border-red">
                <h3>Contas a pagar</h3>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
                <tr>
                    <td>Salário</td>
                    <td>R$ 2200,00</td>
                </tr>
              </div>
          </Contas>
          <Modal show={showModal} close={closeModal} />
      </Container>
  );
}

export default inicio;