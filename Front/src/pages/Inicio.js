/* eslint-disable react/jsx-no-undef */
/* eslint-disable react-hooks/rules-of-hooks */
import React, { useState, useEffect, useContext } from 'react';
import styled from 'styled-components';
import Header from '../components/Header';
import Modal from '../components/Modal';
import DonutChart from '../components/DonutChart';
import AreaChart from '../components/AreaChart';
import { FiFileMinus, FiFilePlus } from 'react-icons/fi';
import { IconContext } from 'react-icons';
import { Context } from '../Context/AuthContext';

import api from '../api';
import BarChart from '../components/BarChart';

const Container = styled.div`
    width: min(80vw, 1400px);
    margin: 0 auto;
    height: 100vh;
    font-size: 18px;
    padding: 40px 0;

    .border-green {
        border: 2px solid #00DC88;
    }

    .border-red {
        border: 2px solid #FE6161;
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
            padding: 15px 0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 20px;
            font-weight: 600;
            background: transparent;
            border: none;
            cursor: pointer;
            &:first-child:hover {
                opacity: 0.8;
                background-color: rgba(0, 220, 136, .1);
            }
            :last-child:hover {
                opacity: 0.8;
                background-color: rgb(254, 97, 97, .1);
            }
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

const ChartsWrapper = styled.div`
    width: 100%;
    min-height: 237px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 40px;

    .wrapper-chart {
        /* width: 49%; */
        height: 100%;
        padding: 20px;
        padding-bottom: 0;
        border-radius: 10px;
    }

    div#barContainer {
        border: 1px solid #00CD88;
    }
`;

const DonutContainer = styled.div`
    margin-right: 2%;

    h2 {
        margin-bottom: 10px;
    }
    /* padding-right: 15%; */
    /* display: flex; */
    /* justify-content: center; */
`;

function inicio() {

    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);

    const [showModalReceitas, setShowModalReceitas] = useState(false);
    const closeModalReceitas = () => setShowModalReceitas(false)

    const [saldo, setSaldo] = useState(0.0);

    const [contasAPagar, setContasAPagar] = useState([]);
    const [contasAReceber, setContasAReceber] = useState([]);

    useEffect(() => {

        async function getSaldo() {
            await api.get("/usuarios/saldo")
                .then(res => {
                    console.log(res.data)
                    setSaldo(res.data);
                })
        }

        getSaldo();
    }, [])
    
    useEffect(() => {

        async function getContasAReceber() {
            await api.get("/contasareceber")
                .then(res => {
                    console.log("Contas a Receber: ", res.data)
                    setContasAReceber(res.data);
                })
        }

        getContasAReceber();
    }, [])

    useEffect(() => {

        async function getContasAPagar() {
            await api.get("/contasapagar")
                .then(res => {
                    console.log("Contas a Rec: ", res.data)
                    setContasAPagar(res.data);
                })
        }

        getContasAPagar();
    }, [])

  return (
      <>
        <Header />
        <Container>
            <Top>
                <div id="saldo" style={{background: saldo>0 ? '#00DC88' : 'rgb(254, 97, 97, .8)'}}>
                    <h3>Saldo estimado em conta:</h3>
                    <h1>R$ {saldo?.toFixed(2)}</h1>
                </div>
                <div id="buttons">
                <IconContext.Provider value={{size:'1.5em'}}>
                    <button
                        style={{border:'1px solid #00CD88'}}
                        onClick={() => setShowModalReceitas(true)}
                    >
                        <FiFilePlus style={{marginRight:'10px', color:'#00CD88'}}/>Adicionar entrada
                    </button>
                    <button style={{border:'1px solid #FE6161'}} onClick={() => setShowModal(true)} ><FiFileMinus style={{marginRight:'10px', color:'#FE6161'}}/> Adicionar despesa</button>
                </IconContext.Provider>
                </div>
            </Top>
            <Contas>
                <div  className="border-green">
                    <h3>Contas a receber</h3>
                    {contasAReceber?.map((item) => (
                        <tr key={item.id}>
                            <td>{item.nomeConta}</td>
                            <td>{item.categoria}</td>
                        </tr>
                    ))}
                </div>
                <div className="border-red">
                    <h3>Contas a pagar</h3>
                    {contasAPagar?.map((item) => (
                        <tr key={item.id}>
                            <td>{item.nomeConta}</td>
                            <td>{item.categoria.nomeCategoria}</td>
                        </tr>
                    ))}
                </div>
            </Contas>
            <ChartsWrapper>

                <div className="border-green wrapper-chart" style={{width:'49%', height:'237px'}}>
                    {/* <h2>Despesas por categorias</h2>  */}
                    <DonutChart rota="despesas" style={{width:'100%', height:'100%'}} />
                </div>
                <div id="barContainer" className='wrapper-chart' style={{borderColor: saldo > 0 ? '#00DC88' : '#FE6161', width:'49%', height:'100%'}}>
                    {/* <h2>Balanço do mês</h2>  */}
                    <BarChart />
                </div>
            </ChartsWrapper>
            <AreaChart style={{marginTop:'30px'}} />
            <Modal show={showModal} close={closeModal} type="despesas" />
            <Modal show={showModalReceitas} close={closeModalReceitas} type="receitas" />
        </Container>
      </>
  );
}

export default inicio;