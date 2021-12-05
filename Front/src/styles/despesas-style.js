import styled from 'styled-components';

export const Container = styled.div`

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

export const TableHeader = styled.div`

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