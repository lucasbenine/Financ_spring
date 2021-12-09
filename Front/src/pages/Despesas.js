/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useEffect } from 'react';
import api from '../api';
import * as C from '../styles/despesas-style'


import styled from 'styled-components';
import DataTable from '../components/DataTable';
import DonutChart from '../components/DonutChart';
import Header from '../components/Header';
import Modal from '../components/Modal';

import { BsFillCaretLeftFill, BsFillCaretRightFill } from "react-icons/bs";

function pages() {

  const [showModal, setShowModal] = useState(false);
  const closeModal = () => setShowModal(false);

  const [soma, setSoma] = useState(0);

  const token = localStorage.getItem('token')
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
        <Header />
        <C.Container>

          <div className="content">
              <div className="media">
                <h2>Total de despesas</h2>
                <h1>R$ {soma.toFixed(2)}</h1>
              </div>
              <div className="grafico">
                <DonutChart rota="despesas" />
              </div>
          </div>

          <C.TableHeader>
            <h2>Despesas</h2>
            <div>
            <button onClick={() => DiminuiMes()} ><BsFillCaretLeftFill /></button>
            <span>{meses[mes]} - {ano}</span>
            <button onClick={() => AumentaMes()}><BsFillCaretRightFill /></button>
            </div>
            
            <button testid="button-test" onClick={() => setShowModal(true)}>Cadastrar Despesa</button>
          </C.TableHeader>
          
          <DataTable mes={mes} ano={ano} />

          <Modal show={showModal} close={closeModal} type="despesas" />
        </C.Container>
      </>
  );
}

export default pages;