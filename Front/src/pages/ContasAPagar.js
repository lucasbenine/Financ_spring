import styles from '../Contas.css'
import {useState, useEffect} from 'react'
import styled from 'styled-components';
import { IconContext } from 'react-icons';
import { FiFilePlus, FiFileMinus } from 'react-icons/fi';
import api from '../api';
import Header from '../components/Header';
import ModalContas from '../components/ModalContas';
import DonutChart from '../components/DonutChart';

const Container = styled.div`
    width: min(80vw, 1400px);
    height: 100%;
    margin: 0 auto;
`;

const Top = styled.div`

    width: 100%;
    display: flex;
    justify-content: space-between;
    margin-top: 40px;
    height: 200px;

    div#balanco_mensal {
        width: 49%;
        border: 2px solid #00DC88
    }

    div#buttons {
        width: 49%;
        display: flex;
        flex-direction: column;
        justify-content: space-between;

        button {
            width: 100%;
            padding: 25px 0;
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

const Lancamentos = styled.div`
    width: 100%;
    margin-top: 30px;
    text-align: center;
    padding: 20px;
    border: 2px solid #00DC88;

    .border_one {
        padding-bottom: 10px;
        border-bottom: 2px solid #00DC88;
    }
`;

const Table = styled.table`
    width: 100%;
    text-align: left;
    margin-top: 40px;

    th, td {
        padding: 30px 25px;
        background: #FFF;
    }
    
    tbody tr {
        opacity: 0.7;

        &:hover {
            opacity: 1;
        }
    }
`;

function ContasAPagar(){

    const [contasAPagar, setContasAPagar] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const closeModal = () => setShowModal(false);

    useEffect (() => {
        async function buscarContas(){
            await api.get("contasapagar")
                .then(res => {
                    console.log(res.data)
                    setContasAPagar(res.data)
                })
        }
        buscarContas()
    },[])

    return(
        <>
            <Header />
            <Container>
                <Top>
                    <div id="balanco_mensal">
                        <DonutChart rota="contasapagar" />
                        
                    </div>
                    <div id="buttons">
                    <IconContext.Provider value={{size:'1.5em'}}>
                        <button style={{border:'1px solid #00CD88'}}><FiFilePlus style={{marginRight:'10px', color:'#00CD88'}}/> Adicionar entrada</button>
                        <button style={{border:'1px solid #FE6161'}} onClick={setShowModal}><FiFileMinus style={{marginRight:'10px', color:'#FE6161'}}/> Adicionar despesa</button>
                    </IconContext.Provider>
                    </div>
                </Top>    
                    <Lancamentos>
                        <div className="border_one">
                            <h1>Contas A Pagar</h1>
                        </div>
                        <Table style={{width: "100%"}}>
                                <thead>
                                    <tr>
                                        <th>Nome:</th>
                                        <th style={{textAlign:'center'}}>Categoria:</th>
                                        <th style={{textAlign:'end'}}>Valor:</th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    {contasAPagar?.map((item) => (
                                        <tr key={item.id}>
                                            <td>{item.nomeConta}</td>
                                            <td style={{textAlign:'center'}}>{item.categoria.nomeCategoria}</td>
                                            <td style={{textAlign:'end'}}>{item.valorConta.toFixed(2)}</td>
                                        </tr>
                                    ))}    
                                </tbody>  
                        </Table>
                </Lancamentos>
                <ModalContas show={showModal} close={closeModal}/>  
            </Container>
        </>
    )
}

export default ContasAPagar