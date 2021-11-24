import React, { useState } from 'react';


import styled from 'styled-components';
import DataTable from '../components/DataTable';
import DonutChart from '../components/DonutChart';
import Navbar from '../components/Navbar';
import Modal from '../components/Modal';

const Container = styled.div`

  width: min(85%, 1400px);
  height: 92vh;
  background: #f0f0f7;
  margin: 0 auto;
  padding-bottom: 50px;

  div.content {
    width: 100%;
    display: flex;
    justify-content: space-between;
    /* flex-wrap: wrap; */
    margin: 50px 0;

    div.media{
      width: 40%;
      background: #FFFFFF;
      border-radius: 20px;
      box-shadow: 0 1px 4px 0 rgba(0,0,0,.4);
      padding: 30px;
    }

    div.grafico {
      width: max(57%, 350px);
      background: #FFFFFF;
      border-radius: 20px;
      box-shadow: 0 1px 4px 0 rgba(0,0,0,.4);
    }
  }

  @media(max-width: 960px) {
    .content {
      flex-direction: column;

    }
    div.media {
      width: 100% !important;
      margin-bottom: 30px;
    }

    div.grafico {
      width: 100% !important;
    }
  }
`;

const TableHeader = styled.div`

    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    background-color: #FFF;


    button {
        padding: 15px 20px;
        background: #ff7e7c;
        border: none;
        color: #FFF;
        border-radius: 10px;
        font-weight: 600;
        cursor: pointer;
    }
`;

function pages() {

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [showModal, setShowModal] = useState(false);
  const closeModal = () => setShowModal(false);



  return (
      <>  
        <Navbar />
        <Container>
          <div className="content">
            <div className="media">
              <h1>Média mensal<br/>
                  R$ 1250,00
              </h1>
            </div>
            <div className="grafico">
              <DonutChart />
            </div>
          </div>

          <TableHeader>
              <h2>Despesas</h2>
              <span>Novembro 2021</span>
              <button testid="button-test" onClick={() => setShowModal(true)}>Cadastrar Despesa</button>
          </TableHeader>
          <DataTable />
          <Modal show={showModal} close={closeModal}/>
        </Container>
      </>
  );
}

export default pages;