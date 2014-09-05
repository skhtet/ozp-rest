package marketplace.hal

/**
 * Represents the _embedded section of a HAL object
 */
class HalEmbedded extends TreeMap<RelationType, List<AbstractHalRepresentation<?>>> {}
