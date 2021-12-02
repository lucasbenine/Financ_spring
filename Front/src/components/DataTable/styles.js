import styled from "styled-components";

export const Table = styled.table`

    width: 100%;
    border-spacing: 0 1px;
    text-align: left;
    margin-bottom: 30px;
    border: 1px solid #ff7e7c;
    border-top: none;

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

export const ModalDetails = styled.div`    

    width: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
    overflow: hidden;

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
        overflow: hidden;


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
`;

export const ModalConfirm = styled.div`
    width: 100%;
    height: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
    justify-content: center;


    div#modalConfirm {
        position: relative;
        height: fit-content;
        margin-top: 120px;
        background: #FFF;
        padding: 50px 80px;
        line-height: 1.5;
        z-index: 100;

        #fechar {
            position: absolute;
            top: 0;
            right: 15px;
            font-size: 35px;
            transform: rotate(45deg);
            cursor: pointer;
        }
    }

    button {
        width: 100%;
        margin-top: 20px;
        padding: 10px;
        border: none;
        background: #ff7e7c;
        color: #FFF;
        font-weight: bolder;
        cursor: pointer;
    }
`;