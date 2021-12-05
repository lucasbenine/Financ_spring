/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useEffect } from 'react';
import api from '../api';

import * as C from '../styles/despesas-style'
import Navbar from '../components/Navbar'
import DonutChart from '../components/DonutChart'
import DataTableReceita from '../components/DataTableReceita'

import { BsFillCaretLeftFill, BsFillCaretRightFill } from "react-icons/bs";


function receitas() {

    const [soma, setSoma] = useState();

    const token = localStorage.getItem('token')
    const config = {
        headers: {
            'Authorization': `Bearer ${token}`
        }
      };

    useEffect(() => {

        async function buscarSomaReceitas() {
            const response = await api.get('receitas/soma', config);
            console.log(response);
            setSoma(response.data);
        
        }
  
        buscarSomaReceitas();
  
    }, [])

    var data = new Date();
    var mesAtual = data.getMonth();
    var anoAtual = data.getFullYear();

    const [mes, setMes] = useState(mesAtual);
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
        <C.Container>
            <div className="content">
                <div className="media">
                    <h1>Total de receitas<br/>
                        R$ {soma}
                    </h1>
                </div>
                <div className="grafico">
                    <DonutChart rota="receitas" />
                </div>
            </div>

            <C.TableHeader style={{borderColor:'#00DC88'}}>
                <h2>Receitas</h2>
                <div>
                <button style={{backgroundColor:'#00DC88'}} onClick={() => DiminuiMes()} ><BsFillCaretLeftFill /></button>
                <span>{meses[mes]} - {ano}</span>
                <button style={{backgroundColor:'#00DC88'}} onClick={() => AumentaMes()}><BsFillCaretRightFill /></button>
                </div>
                
                <button style={{backgroundColor:'#00DC88'}} testid="button-test">Cadastrar Receita</button>
            </C.TableHeader>
            <DataTableReceita style={{borderColor:'#00DC88'}} />
        </C.Container>
      </>
  );
}

export default receitas;