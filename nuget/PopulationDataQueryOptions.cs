using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.PopulationData
{
    /// <summary>
    /// Query options for the Population Data API
    /// </summary>
    public class PopulationDataQueryOptions
    {
        /// <summary>
        /// ISO 2 or 3-letter country code (e.g., US, USA, GB, GBR)
        /// </summary>
        [JsonProperty("country")]
        public string Country { get; set; }

        /// <summary>
        /// Specific year to retrieve data for (1960-present). Returns latest if not specified.
        /// </summary>
        [JsonProperty("year")]
        public string Year { get; set; }
    }
}
