import styled from "styled-components";

export const Container = styled.div`
    width: 100%;
    height: 100%;
    position: fixed;
    bottom: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;

    div#modal-container {
        width: 550px;
        height: 600px;
        background-color: #FFF;
        padding: 30px;
        position: relative;
        
        border-radius: 10px;
        border: 2px solid #FE6161;
        z-index: 99;

        #fechar {
            position: absolute;
            top: 0;
            right: 15px;
            font-size: 35px;
            transform: rotate(45deg);
            cursor: pointer;
        }

        #headerModal {
            margin-bottom: 70px;
            padding: 5px !important;
            font-size: 30px;

            h3 {
                text-transform: capitalize;
            }
        }

        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;

            .input-despesas{
                width: 220px;
                margin-bottom: 60px;

                label {
                    position: relative;
                    margin-left: 2px;
                }

                input, select, textarea {
                    width: 100%;
                    padding: 10px 5px;
                    border-radius: 10px;
                    border: 1px solid rgba(0,0,0.4);
                    margin-top: 5px;
                }

                textarea {
                    height: 150px;
                    resize: none;
                    
                }
            }

            button {
                padding: 10px 20px;
                height: 50px;
                margin-top: 100px;
                background: #ff7e7c;
                color: #FFF;
                border: none;
                border-radius: 10px;

                margin-right: 10px;
                font-size: 20px;
            }
        }
    }
`;