import styles from '../Contas.css'

function ContasAReceber(){

    return(
        <div>
            <div className="two_divs">
                <div className="balanco_mensal">
                    <h1>Balanço mensal - Contas Fixas:</h1>
                </div>
                <div className="relatorio_contas">
                    <button className="green">Relatório de Recebimentos</button>
                    <button className="green">Adicionar Recebimento</button>
                    <button className="green">Editar Recebimento</button>
                    <button className="green">Remover Recebimento</button>
                </div>
            </div>    
                <div className="lancamentos">
                    <div className="border_one">
                        <h1>Contas A Receber</h1>
                    </div>
                    <ul>
                        <li>Salário</li>
                        <li>Investimentos</li>
                    </ul>
                </div>  
        </div> 
    )
}

export default ContasAReceber