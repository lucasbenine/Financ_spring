import React, { useEffect, useState } from 'react';
import api from "../../api";
import { formatLocalDate } from '../../utils/format';
import { MdModeEdit, MdDelete, MdClose } from "react-icons/md";
import axios from 'axios';
import * as C from '../DataTable/styles';
import ModalEdit from '../ModalEdit';


const DataTableReceita = ({mes, ano}) => {

    const [receita, setReceita] = useState([]);

    const token = localStorage.getItem('token')
    const config = {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    };

    const [mesA, setMesA] = useState(12)

    if(mes !== mesA) {
        async function buscarReceitas() {
            const response = await api.get('receitas', config);
            console.log(response);
            setReceita(response.data);
            setMesA(mes)
        
        }

        buscarReceitas();
    }

    const [show, setShow] = useState(false);
    const close = () => setShow(false);

    const [receitaAtual, setReceitaAtual] = useState([]);

    function handleTeste(item) {
        setShow(true);
        setReceitaAtual(item);
    }

    const [showModalConfirm, setShowModalConfirm] = useState(false);
    const closeModalConfirm = () => setShowModalConfirm(false);

    function apagarReceita() {
        axios.delete(`http://localhost:8080/receitas/${receitaAtual.id}`, config)
            .then(window.location.reload())
        
    }

    const [showModalEdit, setShowModalEdit] = useState(false)
    const closeModalEdit = () => setShowModalEdit(false)


    return (
        <>
            <C.Table data-testid="table-test" style={{borderColor:'#00DC88'}}>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th style={{textAlign:'center'}}>Categoria</th>
                        <th style={{textAlign:'end'}}>Preço</th>
                    </tr>
                </thead>
                <tbody>
                    {receita?.map((item) => (
                        <tr key={item.id} onClick={() => handleTeste(item)}>
                            <td>{item.nome}</td>
                            <td style={{textAlign:'center'}}>{item.categoria.nomeCategoria}</td>
                            <td style={{textAlign:'end', color:'#00DC88', fontWeight:'bold'}}>R$ {item.preco.toFixed(2)}</td>
                            {/* <td>{formatLocalDate(item.data, "dd/MM/yyyy")}</td> */}
                            {/* <td>{item.descricao}</td> */}
                            {/* <td style={{height: '100%', display:'flex', justifyContent:'center'}}><MdModeEdit /></td>
                            <td><MdDelete /></td> */}
                        </tr>
                    ))}
                </tbody>
            </C.Table>

            <C.ModalDetails data-testid="modalDetails" style={{
                display: show ? 'flex' : 'none'
            }}>
                <a onClick={close}><MdClose /></a>
                <div id="modalContainer">
                    <div id="container">
                        <div>
                            <h3>{receitaAtual.nome}</h3>
                            <p>R$ {receitaAtual.preco}</p>
                        </div>
                        <div>
                            <div className="details">
                                <span>Data</span>
                                <p>{receitaAtual.data}</p>
                            </div>
                            <div className="details">
                                <span>Categoria</span>
                                {/* <p>{despesaAtual.categoria.nomeCategoria}</p> */}
                            </div>
                            <div className="details">
                                <span>Descrição</span>
                                <p>{receitaAtual.descricao}</p>
                            </div>
                        </div>
                        <div>
                            <button onClick={() => setShowModalEdit(true)} ><MdModeEdit /> Editar</button>
                            <button onClick={() => setShowModalConfirm(true)} id="excluir" ><MdDelete /> Excluir</button>
                        </div>
                    </div>
                </div> 
                <div className="wrapper"></div>
            </C.ModalDetails>

            <C.ModalConfirm style={{
                display: showModalConfirm ? 'flex' : 'none'
            }}>
                <div id="modalConfirm">
                    <div id="fechar" onClick={closeModalConfirm}>+</div>

                    <p>Você tem certeza que deseja apagar a <br /> receita "{receitaAtual.nome}"</p>
                    <button onClick={() => apagarReceita()}>Sim</button>
                    <button style={{background:'#aaa', marginTop:'10px'}} onClick={closeModalConfirm}>Não</button>
                </div>
                <div className="wrapper" />
            </C.ModalConfirm>
            <ModalEdit show={showModalEdit} close={closeModalEdit} despesa={receitaAtual} type="receitas" />
        </>
    );
}

export default DataTableReceita;