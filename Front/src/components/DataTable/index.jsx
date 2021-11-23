import React, { useEffect, useState } from 'react';
import api from "../../api";
import { DespesaPage } from "../../types/despesa";
import { formatLocalDate } from '../../utils/format';
import styled from 'styled-components';
import { MdModeEdit, MdDelete, MdClose } from "react-icons/md";
import token from '../../token';

// const TableHeader = styled.div`

//     width: 100%;
//     display: flex;
//     justify-content: space-between;
//     align-items: center;
//     padding: 20px;
//     background-color: #FFF;


//     button {
//         padding: 15px 20px;
//         background: #ff7e7c;
//         border: none;
//         color: #FFF;
//         border-radius: 10px;
//         font-weight: 600;
//         cursor: pointer;
//     }
// `;


const Table = styled.table`

    width: 100%;
    border-spacing: 0 1px;
    text-align: left;
    margin-bottom: 30px;

    th, td {
        padding: 30px 25px;
        background: #FFFFFF;
    }
    
    tbody tr {
        opacity: 0.7;

        &:hover {
            opacity: 1;
        }
    }

`;

const ModalDetails = styled.div`    

    width: 100%;
    position: fixed;
    bottom: 0;
    left: 0;

    a {
        position: absolute;
        top: 0;
        right: 0;
        z-index: 100;
        padding: 20px;
        cursor: pointer;

        &:hover {
            color: #ff7e7c;
        }
    }

    div#modalContainer {
        
        width: 100%;
        z-index: 99;
        background-color: #FFF;
        display: flex;
        justify-content: center;
        padding: 60px 0;


        div#container{
            width: min(90%, 1000px);
            display: flex;
            justify-content: space-between;

            h3 {
                font-size: 25px;
                margin-bottom: 10px;
            }

    
            .details {
                margin-bottom: 10px;
    
                span {
                    color: #aaa;
                }
    
                p {
                    margin-top: 5px;
                }
            }
    
            button {
                display: block;
                padding: 10px;
                border: none;
                background: transparent;
                cursor: pointer;
    
                &:hover {
                    color: #8DB892;
                }
            }
    
            button#excluir:hover {
                color: #ff7e7c;
    
            }
        }

        
    }
    div#wrapper {
        width: 100%;
        height: 100%;
        position: fixed;
        overflow: hidden;
        opacity: .5;
        z-index: 98;
        top: 0;
        left: 0;
        background: rgba(0,0,0,.4);
    }

`;

const DataTable = () => {

    // const [page, setPage] = useState<DespesaPage>({
    //     first: true,
    //     last: true,
    //     number: 0,
    //     totalElements: 0,
    //     totalPages: 0
    // });
    const [despesa, setDespesa] = useState([]);

    useEffect(() => {

        // const token2 = token;

        const config = {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        };

        async function buscarDespesas() {
            const response = await api.get('despesas/user', config);
            console.log(response);
            setDespesa(response.data);
        
        }

        buscarDespesas();

    }, [])

    const [show, setShow] = useState(false);
    const close = () => setShow(false);

    const [despesaAtual, setDespesaAtual] = useState([]);

    function handleTeste(item) {
        setShow(true);
        console.log(item)
        setDespesaAtual(item);
    }

    return (
        <>
            {/* <TableHeader>
                <h2>Despesas</h2>
                <span>Novembro 2021</span>
                <button>Cadastrar Despesa</button>
            </TableHeader> */}
            <Table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th style={{textAlign:'center'}}>Categoria</th>
                        <th style={{textAlign:'end'}}>Preço</th>
                        {/* <th>Data</th>
                        <th>Descrição</th>
                        <th style={{width: '50px'}}>Editar</th>
                        <th style={{width: '85px'}}>Apagar</th> */}
                    </tr>
                </thead>
                <tbody>
                    {despesa?.map((item) => (
                        <tr key={item.id} onClick={() => handleTeste(item)}>
                            <td>{item.nome}</td>
                            <td style={{textAlign:'center'}}>{item.categoria.nomeCategoria}</td>
                            <td className="despesa" style={{textAlign:'end'}}>R$ {item.preco.toFixed(2)}</td>
                            {/* <td>{formatLocalDate(item.data, "dd/MM/yyyy")}</td> */}
                            {/* <td>{item.descricao}</td> */}
                            {/* <td style={{height: '100%', display:'flex', justifyContent:'center'}}><MdModeEdit /></td>
                            <td><MdDelete /></td> */}
                        </tr>
                    ))}
                </tbody>
            </Table>

            <ModalDetails style={{
                display: show ? 'flex' : 'none'
            }}>
                <a onClick={close}><MdClose /></a>
                <div id="modalContainer">
                    <div id="container">
                        <div>
                            <h3>{despesaAtual.nome}</h3>
                            <p className="despesa">R$ {despesaAtual.preco}</p>
                        </div>
                        <div>
                            <div className="details">
                                <span>Data</span>
                                <p>{despesaAtual.data}</p>
                            </div>
                            <div className="details">
                                <span>Categoria</span>
                                {/* <p>{despesaAtual.categoria.nomeCategoria}</p> */}
                            </div>
                            <div className="details">
                                <span>Descrição</span>
                                <p>{despesaAtual.descricao}</p>
                            </div>
                        </div>
                        <div>
                            <button><MdModeEdit /> Editar</button>
                            <button id="excluir"><MdDelete /> Excluir</button>
                        </div>
                    </div>
                </div> 
                <div id="wrapper"></div>
            </ModalDetails>
        </>
    );
}

export default DataTable;