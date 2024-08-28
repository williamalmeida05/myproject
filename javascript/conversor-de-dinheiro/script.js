const button = document.getElementById("convert-button")
const select = document.getElementById("currency-select")



const dolar = 5.48
const euro = 6.19
const bitcoin = 346.771

const convertValues = () => {
    const inputReal = document.getElementById("input-real").value
    const realValueText = document.getElementById("real-value-text")
    const currencyValueText = document.getElementById("currency-value-text")

    realValueText.innerHTML = inputReal

    currencyValueText.innerHTML = new Intl.NumberFormat("pt-BR", {
        style: "currency",
        currency: "BRL",
    }).format(inputReal)

    if (select.value === "US$ Dólar americano") {
        currencyValueText.innerHTML = new Intl.NumberFormat("en-US", {
            style: "currency",
            currency: "USD",
        }).format(inputReal / dolar)
    }

    if (select.value === "€ Euro") {
        currencyValueText.innerHTML = new Intl.NumberFormat("de-DE", {
            style: "currency",
            currency: "EUR",
        }).format(inputReal / euro)
    }

    if (select.value === "Bitcoin"){
        currencyValueText.innerHTML = new Intl.NumberFormat("en-US",{
            style: "currency",
            currency: "BTC",
        }).format(inputReal/bitcoin)
    }

}

const changeCurrency = () => {
    const currencyName = document.getElementById("currency-name")
    const currencyImg = document.getElementById("currency-img")

    if (select.value === 'US$ Dólar americano') {
        currencyName.innerHTML = "Dólar Americano"
        currencyImg.src = "./assets/bandeira-eua.png"
    }

    if (select.value === '€ Euro') {
        currencyName.innerHTML = "Euro"
        currencyImg.src = "./assets/logo-euro.png"
    }

    if (select.value === 'Bitcoin'){
        currencyName.innerHTML = "Bitcoin"
        currencyImg.src = "./assets/logo-bitcoin.png"
    }

    convertValues()
}


button.addEventListener("click", convertValues)
select.addEventListener("change", changeCurrency)
