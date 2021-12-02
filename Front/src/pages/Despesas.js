/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useEffect } from 'react';
import api from '../api';
import token from '../token';


import styled from 'styled-components';
import DataTable from '../components/DataTable';
import DonutChart from '../components/DonutChart';
import Navbar from '../components/Navbar';
import Modal from '../components/Modal';

import { BsFillCaretLeftFill, BsFillCaretRightFill } from "react-icons/bs";

const Container = styled.div`

  width: min(80%, 1400px);
  height: 92vh;
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
    margin-top: 50px;
    border: 1px solid #ff7e7c;
    border-bottom: none;

    div {

      button {
        padding: 10px;
      }

      span {
        margin: 0 20px;
      }
    }
    


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

  const [showModal, setShowModal] = useState(false);
  const closeModal = () => setShowModal(false);

  const [soma, setSoma] = useState(0);

  const config = {
    headers: {
        'Authorization': `Bearer ${token}`
    }
  };

  useEffect(() => {

      async function buscarSomaDespesas() {
          const response = await api.get('despesas/soma', config);
          console.log(response);
          setSoma(response.data);
      
      }

      buscarSomaDespesas();

  }, [])

  var data = new Date();
  var mesAtual = data.getMonth();
  var anoAtual = data.getFullYear();

  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [mes, setMes] = useState(mesAtual);
  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [ano, setAno] = useState(anoAtual);

  var meses = new Array(
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  );

  function DiminuiMes() {
    if(mes === 0) {
      setMes(11)
      setAno(ano-1)
    }
    else {
      setMes(mes-1)
    }
  }

  function AumentaMes() {
    if(mes === 11) {
      setMes(0)
      setAno(ano+1)
    }
    else {
      setMes(mes+1)
    }
  }

  return (
      <>  
        <Navbar />
        <Container>

          <div className="content">
              <div className="media">
                <h1>Total de despesas<br/>
                    R$ {soma}
                </h1>
              </div>
              <div className="grafico">
                <DonutChart />
              </div>
          </div>

          <TableHeader>
              <h2>Despesas</h2>
              <div>
                <button onClick={() => DiminuiMes()} ><BsFillCaretLeftFill /></button>
                <span>{meses[mes]} - {ano}</span>
                <button onClick={() => AumentaMes()}><BsFillCaretRightFill /></button>
              </div>
              
              <button testid="button-test" onClick={() => setShowModal(true)}>Cadastrar Despesa</button>
          </TableHeader>
          <DataTable mes={mes} ano={ano} />

          <Modal show={showModal} close={closeModal}/>
        </Container>
      </>
  );
}

export default pages;